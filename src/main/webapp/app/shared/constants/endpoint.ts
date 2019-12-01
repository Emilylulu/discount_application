const BASE_URL = 'http://localhost:8080';

const endpoints = {
  ALL_CLOTHES: BASE_URL + '/cloth/all',
  ALL_TOYS: BASE_URL + '/toy/all',
  ALL_BOOKS: BASE_URL + '/book/all',
  ALL_GAMES: BASE_URL + '/game/all',
  ALL_JEWELRY: BASE_URL + '/jewelry/all',
  ALL_PURSE: BASE_URL + '/purse/all',
  ONE_ITEM: BASE_URL + '/book/user/',
  ADD_ITEM: BASE_URL + '/purchaseHistory/add/',
  ADD_SAVE: BASE_URL + '/entities/save/add/',
  ALL_SAVE: BASE_URL + '/entities/save/all',
  REVIEW: BASE_URL + '/book/user/review/',
  RATING: BASE_URL + '/book/user/review/rating/',
  SEARCH: BASE_URL + '/search/',
  MAY_LIKE: BASE_URL + '/entities/mayLike/all',
  History: BASE_URL + '/entities/history/all',
  SIMITEMS: BASE_URL + '/book/user/simitems/'
};

export default endpoints;
