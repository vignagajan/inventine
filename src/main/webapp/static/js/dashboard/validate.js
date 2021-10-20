y = Array.prototype.slice.call(document.getElementsByTagName("input"));
z = Array.prototype.slice.call(document.getElementsByTagName("select"));
y = y.concat(z);

var i = 0;

for (i = 0; i < y.length; i++) {

    validateInput(y[i]);

}

function validateInput(element){

    const id = element.getAttribute("id");
    const error_class = '#'+id+' + span.error';
    const error = document.querySelector(error_class);

    displayError(element,error,'#900');

}

function displayError(element,error,error_color){

    element.addEventListener('input', function (event) {

        const isValid = (element.validity.valid);

        if (isValid) {


            error.className = 'error';
            error.style.display = 'none';
            element.className = '';
            element.style.borderColor = 'green';
            element.previousElementSibling.style.color = 'green';

        } else {

            error.style.display = 'block';
            error.className = 'error active';
            error.style.backgroundColor = error_color;
            element.style.borderColor = error_color;
            element.previousElementSibling.style.color = error_color;

        }
    });

}

