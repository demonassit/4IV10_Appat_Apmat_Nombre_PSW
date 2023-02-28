//problema 1


//problema 2


//problema 3
function problema3(){

    //primero necesitamos definir un alfabeto

    var alfabeto = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

    //VAMOS A OBTENER A ENTRADA DE LOS DATOS
    var p3_input = document.querySelector('#p3-input').value;
    
    //lo que necesitamos es separar todo por comas
    var p3_palabras = p3_input.split(',');

    //necesitamos una funcion que se encargue de recuperar cada palabra
    //tengo que eliminar los espacios

    p3_palabras = p3_palabras.map(function (palabras){
        return palabras.replace(/\s/g, '').toUppercase();
    });

    //hay que calcular los caracteres unicos 
    var p3_res = '';

    //una funcion que se encargue de calcular que contienen el arreglo y separar cara carecter y contarlo
    p3_palabras.forEach(function(palabra, i){

        var letras_unicas = [];
        var palabra_array = palabra.split('');

        //debo iterar el alfabeto
        alfabeto.forEach(function(letra, j){
            //itero cada palabra
            palabra_array.forEach(function(letras_palabras, k){
                //comprobar que la letrea este dentro dle alfabeto
                if(letras_palabras == letra){
                    //si la letra no la hemos contado la agregamos a un array para contar las letras unicas
                    if(letras_unicas.indexOf(letra)<0){
                        letras_unicas.push(letra);
                    }
                }
            });
        });
        //vamos a contar la salida
        p3_res += 'Palabra: ' + palabra + ' = ' + letras_unicas.length + '\n';
    });
    //imprimir salida
    document.querySelector('#p3-output').textContent = p3_res;
}