document.addEventListener('DOMContentLoaded', function() {
    const campoImg = document.getElementById("imgProducto");
    const campoTitulo = document.getElementById("tituloProducto");
    const campoDesc = document.getElementById("descripcionProducto");
    const form = document.querySelector('.needs-validation');

    // Función para mostrar alertas de SweetAlert2
    function mostrarAlerta(mensaje, tipo) {
        Swal.fire({
            title: tipo === 'success' ? '¡Éxito!' : 'Error',
            text: mensaje,
            icon: tipo,
            confirmButtonText: 'Aceptar'
        });
    }

    // Validación en tiempo real para el campo Título
    campoTitulo.addEventListener('input', function() {
        campoTitulo.classList.toggle('is-invalid', campoTitulo.value.trim() === "");
        campoTitulo.classList.toggle('is-valid', campoTitulo.value.trim() !== "");
    });

    // Validación en tiempo real para el campo Descripción
    campoDesc.addEventListener('input', function() {
        campoDesc.classList.toggle('is-invalid', campoDesc.value.trim() === "");
        campoDesc.classList.toggle('is-valid', campoDesc.value.trim() !== "");
    });

    // Configuración de Cloudinary para la imagen
    const myWidget = cloudinary.createUploadWidget({
        cloudName: 'dylf0o4fh', // Reemplaza con tu Cloud Name
        uploadPreset: 'ml_default' // Reemplaza con tu Upload Preset
    }, (error, result) => {
        if (!error && result && result.event === "success") {
            campoImg.value = result.info.secure_url; // URL de la imagen subida
            campoImg.classList.remove('is-invalid');
            campoImg.classList.add('is-valid');
        }
    });

    // Abrir el widget de Cloudinary al hacer clic en el botón de seleccionar archivo
    document.getElementById("uploadButton").addEventListener('click', function() {
        myWidget.open();
    });

    // Validación al enviar el formulario
    form.addEventListener('submit', function(event) {
        let isValid = true;

        // Verificar todos los campos
        [campoTitulo, campoDesc, campoImg].forEach(field => {
            if (field.value.trim() === "") {
                field.classList.add('is-invalid');
                isValid = false;
            } else {
                field.classList.remove('is-invalid');
                field.classList.add('is-valid');
            }
        });

        if (!isValid) {
            event.preventDefault(); // Evitar el envío si hay campos inválidos
            event.stopPropagation();
            mostrarAlerta("Por favor, completa todos los campos correctamente.", 'error');
        } else {
            event.preventDefault(); // Prevenir envío para mostrar la alerta de éxito

            // Obtener el token del sessionStorage
		const token = sessionStorage.getItem('authToken');
		
		// Configurar headers con el token
		const headers = new Headers();
		headers.append('Authorization', `Bearer: ${token}`);
		headers.append('Content-Type', 'application/json');
		
		// Configurar el objeto con los datos del servicio
		const servicioData = {
		    nombre: campoTitulo.value,
		    descripcion: campoDesc.value,
		    imagen: campoImg.value,
		    cotizacion: null // Cambiar este valor si es necesario
		};
		
		// Configurar las opciones de la petición
		const requestOptions = {
		    method: 'POST',
		    headers: headers,
		    body: JSON.stringify(servicioData),
		    redirect: 'follow'
		};

            // Enviar la solicitud al backend para guardar el servicio
            fetch("/api/servicios/", requestOptions)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Error al agregar el servicio. Verifica que el token es válido.');
                    }
                    return response.json();
                })
                .then(result => {
                    mostrarAlerta("El servicio se ha agregado correctamente.", 'success');
                    console.log(result);
                    form.reset();
                    [campoImg, campoTitulo, campoDesc].forEach(field => {
                        field.classList.remove('is-valid', 'is-invalid');
                    });
                    form.classList.remove('was-validated');
                })
                .catch(error => {
                    console.error(error);
                    mostrarAlerta(error.message, 'error');
                });
        }
    });
});
