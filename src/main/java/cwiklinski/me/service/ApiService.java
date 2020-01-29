package cwiklinski.me.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cwiklinski.me.config.PropertiesConfiguration;
import cwiklinski.me.model.SuperModel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.logging.Logger;

public class ApiService {
    private PropertiesConfiguration propertiesConfiguration;
    private Logger logger = Logger.getLogger(ApiService.class.getName());
    private final String REST_URI;
    private String FULL_REQUEST_API_URI;
    private ObjectMapper objectMapper;
    private SuperModel superModel;

    public ApiService() {
        this.objectMapper = new ObjectMapper();
        this.propertiesConfiguration = new PropertiesConfiguration();
        this.REST_URI = propertiesConfiguration.getProp().getProperty("api.url");
    }

    public SuperModel fetchSubjectInformation(String input) {

        try {
            FULL_REQUEST_API_URI = buildUriRequestByNips(input);
            URL apiUri = new URL(FULL_REQUEST_API_URI);
            superModel = objectMapper.readValue(apiUri, SuperModel.class);
        } catch (NullPointerException e) {
            logger.warning("Brak podanych NIPów ");
            logger.warning(e.getMessage());

        } catch (MalformedURLException e) {
            logger.warning("Adres API jest nieprawdiłowy lub brak z nim połączenia");
            logger.warning(e.getMessage());
        } catch (IOException e) {
            logger.warning("Zwrócono kod błędu");
            logger.warning(e.getMessage());
        }
        return superModel;
    }

    private String buildUriRequestByNips(String input) {
        if (input.isEmpty()) throw new NullPointerException();
        String[] nips = input.split("\\s*,\\s*");
        boolean first = true;
        StringBuilder result = new StringBuilder();
        result.append(REST_URI);
        for (String nip : nips) {
            if (first)
                first = false;
            else
                result.append(",");
            result.append(nip);
        }
        result.append("?date=");
        result.append(LocalDate.now());
        System.out.println(result.toString());
        return result.toString();
    }
}
