requirejs.config({
    baseUrl: '/js/lib',
    paths: {
        app: '/js/app'
    }
});

requirejs(['/js/app/main.js']);
