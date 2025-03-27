console.log("script loaded");

let currentTheme = getTheme();
changeTheme(currentTheme);

function changeTheme(currentTheme){
    document.querySelector('html').classList.add(currentTheme);

    const changeThemeButton = document.querySelector('#theme_change_button');
    changeThemeButton.querySelector('span').innerText = currentTheme === 'dark' ? 'Light' : 'Dark';
    changeThemeButton.addEventListener('click', () => {
        document.querySelector('html').classList.remove(currentTheme);
        if(currentTheme === 'dark'){
            currentTheme = 'light';
        }
        else{
            currentTheme = 'dark';
        }
        setTheme(currentTheme);
        document.querySelector('html').classList.add(currentTheme);

        changeThemeButton.querySelector('span').innerText = currentTheme === 'dark' ? 'Light' : 'Dark';
    })
}

// set theme to local storage
function setTheme(theme){
    localStorage.setItem("theme", theme);
}

// get theme from local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    if(theme == null){
        return "light";
    }
    else{
        return theme;
    }
}