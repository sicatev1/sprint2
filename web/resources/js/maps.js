// This example adds a search box to a map, using the Google Place Autocomplete
// feature. People can enter geographical searches. The search box will return a
// pick list containing a mix of places and predicted search terms.

// This example requires the Places library. Include the libraries=places
// parameter when you first load the API. For example:
// <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

  
  //Crea el array de las direcciones ingresadas
  var waypts = [];

function initAutocomplete() {
  var directionsService = new google.maps.DirectionsService;
  var directionsDisplay = new google.maps.DirectionsRenderer;
  var map = new google.maps.Map(document.getElementById('map'), {
    center: { lat: 3.4516467, lng: -76.5319854 },
    zoom: 13,
    mapTypeId: 'roadmap'
  });
  directionsDisplay.setMap(map);

  document.getElementById('submit').addEventListener('click', function() {
    calculateAndDisplayRoute(directionsService, directionsDisplay);
  });

  // Create the search box and link it to the UI element.
  var input = document.getElementById('pac-input');
  var searchBox = new google.maps.places.SearchBox(input);
  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

  // Bias the SearchBox results towards current map's viewport.
  map.addListener('bounds_changed', function () {
    searchBox.setBounds(map.getBounds());
  });

  var markers = [];
  // Listen for the event fired when the user selects a prediction and retrieve
  // more details for that place.
  var address = null;
  searchBox.addListener('places_changed', function () {

    var places = searchBox.getPlaces();

    if (places.length == 0) {
      return;
    }

    // Clear out the old markers.
    markers.forEach(function (marker) {
      marker.setMap(null);
    });
    markers = [];

    // For each place, get the icon, name and location.
    var bounds = new google.maps.LatLngBounds();
    places.forEach(function (place) {

      //Captura la localización - Latitud, Longitud
      var location = place.geometry.location;
      var lat = location.lat();
      var lng = location.lng();
      address = lat + ", " + lng;

      if (!place.geometry) {
        console.log("Returned place contains no geometry");
        return;
      }
      var icon = {
        url: place.icon,
        size: new google.maps.Size(71, 71),
        origin: new google.maps.Point(0, 0),
        anchor: new google.maps.Point(17, 34),
        scaledSize: new google.maps.Size(25, 25)
      };

      // Create a marker for each place.
      markers.push(new google.maps.Marker({
        map: map,
        icon: icon,
        title: place.name,
        position: place.geometry.location
      }));

      if (place.geometry.viewport) {
        // Only geocodes have viewport.
        bounds.union(place.geometry.viewport);
      } else {
        bounds.extend(place.geometry.location);
      }
    });
    map.fitBounds(bounds);
  });


//Guarda las coordenadas dentro del array waypts
  function saveAddress() {

    //Array de direcciones
    waypts.push({
      location: address,
      stopover: true
    });

    addOptions("address", {
      location: address,
      stopover: true
    });
    console.log(waypts)
  }

  // Rutina para agregar opciones a un <select>
  function addOptions(domElement, waypt) {
    var select = document.getElementById(domElement);

    var option = document.createElement("option");
    option.text = waypt.location;
    select.add(option);
  }

  //Ejecucion del boton que almacena las direcciones
  document.getElementById('save').addEventListener('click', saveAddress);

}


//Calcula la ruta con los valores ingresados
function calculateAndDisplayRoute(directionsService, directionsDisplay) {

  //Array de direcciones tomadas de la lista
  var waypts2 = [];

  //Se toma las direcciones de la lista
  var checkboxArray = document.getElementById('address');
  for (var i = 0; i < checkboxArray.length; i++) {
      waypts2.push({
        location: checkboxArray[i].value,
        stopover: true
      });
  }

  //Saca el origen y el destino como parametros
  var origin = waypts2[0].location;
  var destination = waypts2[waypts2.length-1].location;

  //Se crea un nuevo array eliminando el origen y destino
  var waypts3 = waypts2.slice(1, waypts2.length-1);;

  //Se crea la ruta a partir de los datos
  directionsService.route({ 
    origin: origin,
    destination: destination,
    waypoints: waypts3,
    optimizeWaypoints: true,
    travelMode: 'DRIVING'
  }, function(response, status) {
    if (status === 'OK') { 
      directionsDisplay.setDirections(response);
      var route = response.routes[0];
    } else {
      window.alert('Directions request failed due to ' + status);
    }
  });

}

//Borra el elemento seleccionado del array y de la lista
function borrarElemento() {
    var x = document.getElementById("address").selectedIndex;
    var y = document.getElementById("address").options;
    //alert("Index: " + x + " is " + y[x].text);

    waypts.splice(x, 1);

    document.getElementById("address").remove(x);

}




