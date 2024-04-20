const PROJECT_NAME = 'Food Panda';

const PORT = 8080;
const API_END_POINT = `http://localhost:${PORT}/api/`;

if (sessionStorage.getItem('loggedIn') === "true" && sessionStorage.getItem('userId') !== null) {
    console.log('here out', location.pathname);
    if (sessionStorage.getItem('admin') === 'true' && location.pathname !== '/admin.html') {
        location.href = '/admin.html';
    } else if (!sessionStorage.getItem('admin') && (location.pathname === '/index.html' || location.pathname === '/admin.html')) {
        location.href = '/home.html';
    }
} else {
    if (location.pathname !== '/index.html') {
        location.href = '/index.html';
    }
}

window.addEventListener('scroll', () => {
    const header = document.querySelector('.header');
    const floatingHeader = document.querySelector('.floating-header');
    if (floatingHeader.getBoundingClientRect().top <= 0) {
        header.classList.add('black');
    } else {
        header.classList.remove('black');
    }
});

const URL_MAP = {
    createUser: `${API_END_POINT}user`,
    validateUser: `${API_END_POINT}user/validateUser`,
    product: `${API_END_POINT}product`,
    userById: `${API_END_POINT}user/id`,
    updateUser: `${API_END_POINT}user/info`,
    createOrder: `${API_END_POINT}order`,
    userOrders: `${API_END_POINT}order/userId`,
    updateProduct: `${API_END_POINT}product/code/price`,
    deleteProduct: `${API_END_POINT}product/code`
};

var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
})

document.querySelector('.project-name').innerText = PROJECT_NAME;