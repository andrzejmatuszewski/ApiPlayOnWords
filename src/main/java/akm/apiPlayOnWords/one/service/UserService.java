package akm.apiPlayOnWords.one.service;

import akm.apiPlayOnWords.one.model.UserIn;
import akm.apiPlayOnWords.one.populator.UserOutPopulator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UserService {

    ObjectMapper mapper = new ObjectMapper();

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
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
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
