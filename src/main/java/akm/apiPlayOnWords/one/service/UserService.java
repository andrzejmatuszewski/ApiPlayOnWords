package akm.apiPlayOnWords.one.service;

import akm.apiPlayOnWords.one.model.UserIn;
import akm.apiPlayOnWords.one.populator.UserOutPopulator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class UserService {

    ObjectMapper mapper = new ObjectMapper();

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    /**
     * https://api.github.com/users/{login}
     *
     * @param login
     * @return UserOut
     */
    public UserIn connectToApi(String login) {

        try {
            URL url = new URL("https://api.github.com/users/" + login);

            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");


            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String output;
            LOG.info("Output from Server ...");
            while ((output = br.readLine()) != null) {
                LOG.info(output);
                sb.append(output);
            }
            conn.disconnect();

            return processResponce(sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserIn processResponce(String responce) {
        try {
            return mapper.readValue(responce, UserIn.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
