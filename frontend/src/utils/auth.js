import Cookies from 'js-cookie'

const uToken = 'u_token'
const darkMode = 'dark_mode';

// get Token
export function getToken() {
    return Cookies.get(uToken);
}

// set Token，1 day, sync with the backend
export function setToken(token) {
    return Cookies.set(uToken, token, {expires: 1})
}

// delete Token
export function removeToken() {
    return Cookies.remove(uToken)
}

export function removeAll() {
    return Cookies.Cookies.removeAll()
}

export function setDarkMode(mode) {
    return Cookies.set(darkMode, mode, {expires: 365})
}

export function getDarkMode() {
    return !(undefined === Cookies.get(darkMode) || 'false' === Cookies.get(darkMode));
}
