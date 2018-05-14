/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Calcula la ruta con los valores ingresados
function calculateAndDisplayRoute(rutas) {
    var directionsService = new google.maps.DirectionsService;
    var directionsDisplay = new google.maps.DirectionsRenderer;
    // var map = new google.maps.Map(document.getElementById('map'));
    var map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 3.4516467, lng: -76.5319854},
        zoom: 13,
        mapTypeId: 'roadmap'
    });
    directionsDisplay.setMap(map);


    var temp = rutas.split("|");
    temp.pop();
    var origen = temp[0];
    var destino = temp[temp.length - 1];
    var waypts3 = temp.slice(1, temp.length - 1);
    var waypts = [];

    for (var i = 0; i < waypts3.length; i++) {
        waypts.push({
            location: waypts3[i],
            stopover: true
        });
    }

    //Se crea la ruta a partir de los datos
    directionsService.route({
        origin: origen,
        destination: destino,
        waypoints: waypts,
        optimizeWaypoints: true,
        travelMode: 'DRIVING'
    }, function (response, status) {
        if (status === 'OK') {
            directionsDisplay.setDirections(response);
            var route = response.routes[0];
        } else {
            window.alert('Directions request failed due to ' + status);
        }
    });
}




