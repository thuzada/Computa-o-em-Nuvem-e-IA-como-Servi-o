package cognitives.services;
import okhttp3.*;

public class Consume {
	public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String chave = "7Km0ZMIwhztyraAri0zCuGEJuwYMWVocpTXtt7lz9pIgvDoOABMAJQQJ99BDACZoyfiXJ3w3AAAEACOG33j0";
        String endpoint = "https://meu-language-service.cognitiveservices.azure.com/";
        
        String url = endpoint + "text/analytics/v3.1/sentiment";

        String json = "{ \"documents\": [{ \"language\": \"pt\", \"id\": \"1\", \"text\": \"Estou muito feliz hoje!\" }] }";

        RequestBody body = RequestBody.create(
            json, MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
            .url(url)
            .post(body)
            .addHeader("Ocp-Apim-Subscription-Key", chave)
            .addHeader("Content-Type", "application/json")
            .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
