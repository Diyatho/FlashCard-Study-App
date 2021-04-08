import axios from 'axios';
// The below steps are commented out because the auth token is linked to axios header. This is done in 
// store-->index.js
// const http = axios.create({
//     baseURL: 'http://localhost:8080'
// });

//axios.get("http://localhost:8080/user/cards

export default{
    getCards(){
        return axios.get('/user/cards');
    },
    createCard(newCard){
    return axios.post('/user/cards/create', newCard);
    }
};

