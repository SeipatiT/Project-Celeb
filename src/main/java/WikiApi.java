import java.net.URL;

public class WikiApi {

    String url = "https://en.wikipedia.org/w/api.php";

    String params = {
            action: "opensearch",
    search: "Hampi",
    limit: "5",
    namespace: "0",
    format: "json"};


        url = url + "?origin=*";
        Object.keys(params).forEach(function(key){url += "&" + key + "=" + params[key];});

        fetch(url)
        .then(function(response){return response.json();})
        .then(function(response) {console.log(response);})
        .catch(function(error){console.log(error);});
}
