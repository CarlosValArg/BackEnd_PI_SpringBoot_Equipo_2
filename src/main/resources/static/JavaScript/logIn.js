document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const txtCorreo = document.getElementById("txtCorreo");
    const txtContraseña = document.getElementById("txtContraseña");
    let valid = true;

    // Función para mostrar alertas de SweetAlert2
    function mostrarAlerta(mensaje, tipo) {
        Swal.fire({
            title: tipo === 'success' ? '¡Éxito!' : 'Error',
            text: mensaje,
            icon: tipo,
            confirmButtonText: 'Aceptar'
        });
    }

    // Validación de campos vacíos
    if (txtCorreo.value.trim() === '') {
        txtCorreo.classList.add('is-invalid');
        valid = false;
    } else {
        txtCorreo.classList.remove('is-invalid');
    }

    if (txtContraseña.value.trim() === '') {
        txtContraseña.classList.add('is-invalid');
        valid = false;
    } else {
        txtContraseña.classList.remove('is-invalid');
    }

    if (!valid) return;

    // Verificar usuario en localStorage
    const usuarioRegistrado = JSON.parse(localStorage.getItem('user')) || null;
    if (usuarioRegistrado) {
        if (usuarioRegistrado.txtCorreo === txtCorreo.value && 
            usuarioRegistrado.txtContraseña === txtContraseña.value) {
            
            const myHeaders = new Headers();
            const raw = JSON.stringify({
                "correo": txtCorreo.value.trim(),
                "contrasena": txtContraseña.value
            });

            fetch("/api/login/", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: raw
            })
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`Error en la autenticación: ${response.statusText}`);
                }
                return response.json();
            })
            .then((result) => {
                console.log(result);
                const token = result.accessToken;
                sessionStorage.setItem('authToken', token);
                console.log("Token guardado: ", token);

                Swal.fire({
                    title: '¡Inicio de sesión exitoso!',
                    text: 'Serás redirigido a la página de inicio',
                    icon: 'success',
                    confirmButtonText: 'Aceptar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        // Almacenar estado de sesión en localStorage
                        localStorage.setItem('sesionIniciada', true);
                        // Redirigir a la página de inicio
                        window.location.href = "index.html"; // Cambia a tu página de inicio
                    }
                });
            })
            .catch((error) => {
                console.error("Error en el inicio de sesión:", error);
                mostrarAlerta("Ocurrió un error al iniciar sesión.", 'error');
            });
        } else {
            mostrarAlerta("Credenciales incorrectas.", 'error');
        }
    } else {
        mostrarAlerta("No hay usuario registrado.", 'error');
    }
});
