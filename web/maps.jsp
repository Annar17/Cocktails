<!DOCTYPE html>
<html>
<head>
    <title>Cocktail Picker</title>

    <link rel="stylesheet" href="css/style.css">
    <style>
        input[type=text], select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
            text-align-last: center;
        }
    </style>

</head>
<body style="background-image: url(images/cocktails.jpg);">

<!-- Google Maps -->
<script>
    var map;

    function createMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {
                lat: 37.9808552,
                lng: 23.7304957
            },
            zoom: 12
        });

        var request = {
            location: map.getCenter(),
            radius: 8047,
            types: ['cafe']
        }

        var service = new google.maps.places.PlacesService(map);

        service.nearbySearch(request, callback);
    }

    function callback(results, status) {
        if (status == google.maps.places.PlacesServiceStatus.OK) {
            console.log(results.length);
            for (var i = 0; i < results.length; i++) {
                createMarker(results[i]);
            }
        }
    }

    function createMarker(place) {
        var placeLoc = place.geometry.location;
        var marker = new google.maps.Marker({
            map: map,
            position: place.geometry.location,
            title: place.name
        })
    }
</script>

<!--header-->
<div class="header">
    <a id="back" href="javascript:history.back()" class="navbar-brand scroll-top" style="float: left; border: 2px solid darkred;">BACK</a>
    <div class="container">
        <h1 style="text-align:center; font-size: 40px; color: white; display:block;">Find nearest bar</h1>
    </div>
</div>

<div id="map" style="width:100%; height:600px;"></div>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBaSgU8JV7VZSce0m0SDzQTN_pLIFavT_8&query=bar&location=lat,lon&radius=8000&callback=createMap"></script>

</body>
</html>
