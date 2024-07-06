const registroService = {
    async registrarUsuario(usuario) {
        await new Promise((resolve) => setTimeout(resolve, 1000));

        return {
            status: 'success',
            message: 'Usuario registrado con éxito'
        };
    }
};

export default registroService;
