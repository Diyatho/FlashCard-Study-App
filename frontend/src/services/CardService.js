import axios from 'axios';

// const http = axios.create({
//     baseURL: 'http://localhost:8080'

// });

//axios.get("http://localhost:8080/user/cards

export default{
    getCards(){
        return axios.get('/user/cards');
    }
    
};

