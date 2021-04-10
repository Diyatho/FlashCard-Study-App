import axios from 'axios';

export default{

    getDecks(){
        return axios.get('/user/decks');
    }
}