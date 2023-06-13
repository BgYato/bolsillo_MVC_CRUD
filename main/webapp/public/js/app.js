function registro() {
    alert("Te has registado, ahora, inicia sesión.")
}
function alertNoDisponible(){
    alert("Pestaña en mantenimiento, intentalo más tarde.")
}

function abrirAlerta() {
    if (document.getElementById("tarjeta").style.display=="block") {
        document.getElementById("tarjeta").style.display = "none";
    } else {
        document.getElementById("tarjeta").style.display = "block";
    }
}