import axios from 'axios';
// The below steps are commented out because the auth token is linked to axios header. This is done in 
// store-->index.js
// const http = axios.create({
//     baseURL: 'http://localhost:8080'
// });

//axios.get("http://localhost:8080/user/cards

export default{
    createDeck(deckName, deckDescription){
        return axios.post('/user/decks/create', {"deckName": deckName, "deckDescription": deckDescription});
        },
        

    getCards(){
        return axios.get('/user/cards');
    },
    createCard(newCard){
    return axios.post('/user/cards/create', newCard);
    },
    getCardById(cardId){
        return axios.get(`user/decks/0/${cardId}`);
    },
    updateCard(card) {
        return axios.put(`user/cards/${card.id}`, card);
      },
    deleteCard(cardID) {
        return axios.delete(`user/cards/${cardID}`);
      },
};

