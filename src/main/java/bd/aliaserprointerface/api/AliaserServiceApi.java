package bd.aliaserprointerface.api;


import bd.aliaserprointerface.model.AliasedObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AliaserServiceApi {
    public AliasedObjectResponse getRecipe(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AliasedObjectResponse> responseEntity = restTemplate
                .getForEntity(url, AliasedObjectResponse.class);
        return responseEntity.getBody();
    }
}
