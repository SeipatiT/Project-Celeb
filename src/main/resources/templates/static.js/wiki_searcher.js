const title = document.querySelector(".article-title"),
    description = document.querySelector(".article-description");

var search = window.location.search;

if(search){
    var api = "https://en.wikipedia.org/w/api.php?format=xml&action=query&prop=extracts&titles=Stack%20Overflow&redirects=true";

    fetch(api)
        .then(response => response.json())
        .then(response => {
            response = response.query.pages;
            var pageId = Object.keys(response)[0];
            var extract = response[pageId].extract;

            title.innerHTML = search;
            description.innerHTML = extract})
}


