if ([[${bookNew.cover}]] !== null){
    var span = document.createElement("span");
    span.setAttribute("class","badge text-bg-info");
    span.append([[${bookNew.cover.getUpdated()}]]);
    document.getElementById('label_file_cover').append(span);
}

if ([[${bookNew.fileEpub}]] !== null){
    var span = document.createElement("span");
    span.setAttribute("class","badge text-bg-info");
    span.append([[${bookNew.fileEpub.getUpdated()}]]);
    document.getElementById('label_file_epub').append(span);
}
if ([[${bookNew.fileFb2}]] !== null){
    var span = document.createElement("span");
    span.setAttribute("class","badge text-bg-info");
    span.append([[${bookNew.fileFb2.getUpdated()}]]);
    document.getElementById('label_file_fb2').append(span);
}
if ([[${bookNew.fileMobi}]] !== null){
    var span = document.createElement("span");
    span.setAttribute("class","badge text-bg-info");
    span.append([[${bookNew.fileMobi.getUpdated()}]]);
    document.getElementById('label_file_mobi').append(span);
}


var cover_ = [[${bookNew.cover}]];
var epub_ = [[${bookNew.fileEpub}]];
var fb2_ = [[${bookNew.fileFb2}]];
var mobi_ = [[${bookNew.fileMobi}]];


if (cover_ !== null){
    var span = document.createElement("span");
    span.setAttribute("class","badge text-bg-info");
    span.append([[${bookNew.cover.getUpdated()}]]);
    document.getElementById('label_file_cover').append(span);
}

if (epub_ !== null){
    var span = document.createElement("span");
    span.setAttribute("class","badge text-bg-info");
    span.append([[${bookNew.fileEpub.getUpdated()}]]);
    document.getElementById('label_file_epub').append(span);
}
if (fb2_ !== null){
    var span = document.createElement("span");
    span.setAttribute("class","badge text-bg-info");
    span.append([[${bookNew.fileFb2.getUpdated()}]]);
    document.getElementById('label_file_fb2').append(span);
}
if (mobi_ !== null){
    var span = document.createElement("span");
    span.setAttribute("class","badge text-bg-info");
    span.append([[${bookNew.fileMobi.getUpdated()}]]);
    document.getElementById('label_file_mobi').append(span);
}





function filter(val, _list) {
    return _list.filter(it => it.indexOf(val) !== -1);
}
    //-----------------------------------------------------------------------------------------------------------
    function exceptionEl(list = [], el){
    for (let i = 0; i < list.length; i++) {
    if (list[i] == el){
    list.splice(i,1);
}
}
}
    function exceptionList (list_all = [], list_select = []){
    for (let i = 0; i < list_select.length; i++) {
    exceptionEl(list_all, list_select[i]);
}
}
    //-----------------------------------------------------------------------------------------------------------
    function clickSeclected(obj, listAll = [], listS = []){
    listAll.push(obj);
    for (let i = 0; i < listS.length; i++) {
    if (obj == listS[i]){
    listS.splice(i,1);
}
}
}
    //-----------------------------------------------------------------------------------------------------------
    function clickAll(obj, listAll = [], listS = []){
    listS.push(obj.value);
    for (let i = 0; i < listAll.length; i++) {
    if (obj.value == listAll[i]){
    listAll.splice(i,1);
}
}
}
    //-----------------------------------------------------------------------------------------------------------
    function inputAuthors(_list = []){
    const inputA = document.getElementById("_authorsListBook");
    var str = "";
    for (let i = 0; i < _list.length; i++) {
    str += _list[i];
    if ( i < _list.length - 1){
    str += ",";
}
}
    inputA.setAttribute("value", str);
}
    //-----------------------------------------------------------------------------------------------------------
    function inputTags(_list = []){
    const inputT = document.getElementById("_tagsListBook");
    var str = "";
    for (let i = 0; i < _list.length; i++) {
    str += _list[i];
    if ( i < _list.length - 1){
    str += ",";
}
}
    inputT.setAttribute("value", str);
}
    //-----------------------------------------------------------------------------------------------------------
    function inputGenres(_list = []){
    const inputG = document.getElementById("_genresListBook");
    var str = "";
    for (let i = 0; i < _list.length; i++) {
    str += _list[i];
    if ( i < _list.length - 1){
    str += ",";
}
}
    inputG.setAttribute("value", str);
}
    //--------------------------------Авторы
    //массив всех элементов
    var listAllAuthors_ = [[${ArrListAllAuthors}]];
    var listAllAuthors = [];
    for (let i = 0; i < listAllAuthors_.length; i++) {
    listAllAuthors[i] = listAllAuthors_[i].name;
}

    //массив выбранных элементов
    var listSelectedAuthors_ = [[${ArrListSelecAuthors}]];
    var listSelectedAuthors = [];
    if (listSelectedAuthors_ !== null) {
    for (let i = 0; i < listSelectedAuthors_.length; i++) {
    listSelectedAuthors[i] = listSelectedAuthors_[i].name;
}
}

    exceptionList(listAllAuthors, listSelectedAuthors);

    //Элемет содержащий все элементы
    const allAuthors = document.getElementById("NameClassAllListAuthors");
    //Элемент содержащий выбранные элементы
    const selectedAuthors = document.getElementById("NameClassSelectListAuthors");

    //--------------------------------------------------------------------------------- Установка чекбоксов
    const checkPublick = document.getElementById("checkPublick");
    const checkEnd = document.getElementById("checkEnd");
    var statBook = ([[${bookNew.book.getStatusBook()}]]);
    var statBook_b = false;
    var visebleBook = ([[${bookNew.book.getVisebleBook()}]]);
    var visebleBook_b = false;

    if (visebleBook !== null){
    if(visebleBook !== 'PRIVATE'){
    visebleBook_b = true;
}
}
    if (statBook !== null){
    if(statBook !== 'PROCESS'){
    statBook_b = true;
}
}

    if (visebleBook_b) {
    checkPublick.setAttribute("checked", "");
}
    if (statBook_b){
    checkEnd.setAttribute("checked", "");
}
    //------------------------------------------------------------------------------- Проверка файлов
    // <span className="badge text-bg-info">New</span> label_file_cover
    // var cover = [[${bookNew.cover}]];
    // var epub = [[${bookNew.fileEpub}]];
    // var fb2 = [[${bookNew.fileFb2}]];
    // var mobi = [[${bookNew.fileMobi}]];
    //
    // if (cover !== null){
    //     // var span = document.createElement("span");
    //     // span.setAttribute("class","badge text-bg-info");
    //     // span.append([[${bookNew.cover.update}]]);
    //     // document.getElementById('label_file_cover').append(span);
    //     // document.getElementById('label_file_cover').append("000000000000000000");
    // }
    // if (epub !== null){
    // }
    // if (fb2 !== null){
    // }
    // if (mobi !== null){
    // }


    //span.append();
    //-------------------------------------------------------------------

    function renderAllAuthors(_list = [], el = document.body) {
        el.innerHTML = _list.map(item => `<option onclick="allAuthorClickEl(this);">${item}</option>`);
    }
    function renderSelectAuthors(_list = [], el = document.body) {
    el.innerHTML = "";
    for (let i = 0; i < _list.length; i++) {
    var span = document.createElement("span");
    span.setAttribute("onclick", "selectedAuthorClickEl(this.outerText)");
    span.setAttribute("class","badge rounded-pill bg-primary");
    span.setAttribute("name", "authorsBook");
    span.append(_list[i]);
    el.appendChild(span);
}
    inputAuthors(_list);
}
    function selectedAuthorClickEl(obj) {
    clickSeclected(obj, listAllAuthors, listSelectedAuthors);
    renderAuthor();
}
    function allAuthorClickEl(obj){
    clickAll(obj, listAllAuthors, listSelectedAuthors);
    renderAuthor();
}
    function renderAuthor(){
    renderAllAuthors(listAllAuthors, allAuthors);
    renderSelectAuthors(listSelectedAuthors, selectedAuthors);
    card_renderListAuthors();
}


    //--------------------------------Жанры
    //массив всех элементов
    var listAllGenres_ = [[${ArrListAllGenres}]];
    var listAllGenres = [];
    for (let i = 0; i < listAllGenres_.length; i++) {
    listAllGenres[i] = listAllGenres_[i].name;
}

    //массив выбранных элементов
    var listSelectedGenres_ = [[${ArrListSelecGenres}]];
    var listSelectedGenres = [];
    if (listSelectedGenres_ !== null) {
    for (let i = 0; i < listSelectedGenres_.length; i++) {
    listSelectedGenres[i] = listSelectedGenres_[i].name;
}
}

    exceptionList(listAllGenres, listSelectedGenres);

    //Элемет содержащий все элементы
    const allGenres = document.getElementById("NameClassAllListGenre");
    //Элемент содержащий выбранные элементы
    const selectedGenres = document.getElementById("NameClassSelectListGenre");


    function renderAllGenres(_list = [], el = document.body) {
    el.innerHTML = _list.map(item => `<option onclick="allGenreClickEl(this);">${item}</option>`);
}
    function renderSelectGenres(_list = [], el = document.body) {
    el.innerHTML = "";
    for (let i = 0; i < _list.length; i++) {
    var span = document.createElement("span");
    span.setAttribute("onclick", "selectedGenreClickEl(this.outerText)");
    span.setAttribute("class","badge rounded-pill bg-secondary");
    span.append(_list[i]);
    el.appendChild(span);
}
    inputGenres(_list);
}
    function selectedGenreClickEl(obj) {
    clickSeclected(obj, listAllGenres, listSelectedGenres);
    renderGenre();
}
    function allGenreClickEl(obj){
    clickAll(obj, listAllGenres, listSelectedGenres);
    renderGenre();
}
    function renderGenre(){
    renderAllGenres(listAllGenres, allGenres);
    renderSelectGenres(listSelectedGenres, selectedGenres);
    card_renderListGenres();
}

    //--------------------------------Тэги
    //массив всех элементов
    var listAllTags_ = [[${ArrListAllTags}]];
    var listAllTags = [];
    for (let i = 0; i < listAllTags_.length; i++) {
    listAllTags[i] = listAllTags_[i].name
}

    //массив выбранных элементов
    var listSelectedTags_ = [[${ArrListSelecTags}]];
    var listSelectedTags = [];
    if (listSelectedTags_ !== null) {
    for (let i = 0; i < listSelectedTags_.length; i++) {
    listSelectedTags[i] = listSelectedTags_[i].name;
}
}

    exceptionList(listAllTags, listSelectedTags);

    //Элемет содержащий все элементы
    const allTags = document.getElementById("NameClassAllListTag");
    //Элемент содержащий выбранные элементы
    const selectedTags = document.getElementById("NameClassSelectListTag");


    function renderAllTegs(_list = [], el = document.body) {
    el.innerHTML = _list.map(item => `<option onclick="allTagsClickEl(this);">${item}</option>`);
}
    function renderSelectTags(_list = [], el = document.body) {
    el.innerHTML = "";
    for (let i = 0; i < _list.length; i++) {
    var span = document.createElement("span");
    span.setAttribute("onclick", "selectedTagsClickEl(this.outerText)");
    span.setAttribute("class","badge rounded-pill bg-success")
    span.append(_list[i]);
    el.appendChild(span);
}
    inputTags(_list);
}
    function selectedTagsClickEl(obj) {
    clickSeclected(obj, listAllTags, listSelectedTags);
    renderTag();
}
    function allTagsClickEl(obj){
    clickAll(obj, listAllTags, listSelectedTags);
    renderTag();
}
    function renderTag(){
    renderAllTegs(listAllTags, allTags);
    renderSelectTags(listSelectedTags,selectedTags);
    card_renderListTags();
}
    //---------------------------------Card
    //Название книги
    function nameBook_inputNameBook(val){
    document.getElementById("card-text-name").innerText = val;
}
    document.getElementById("nameBook").addEventListener('input', e => {nameBook_inputNameBook(e.target.value)});
    //Жанры книги
    function card_renderListGenres(){
    const div_genre =  document.getElementById("card-genres-p");
    div_genre.innerHTML = "";
    for (let i = 0; i < listSelectedGenres.length; i++) {
    var span = document.createElement("span");
    span.setAttribute("class", "badge text-bg-light");
    span.append(listSelectedGenres[i]);
    div_genre.append(span);
}

}
    //Тэги книги
    function card_renderListTags(){
    const tr_tags =  document.getElementById("card-tags-span");
    tr_tags.innerHTML = "";
    var tr = document.createElement("tr");
    var td = document.createElement("td");
    for (let i = 0; i < listSelectedTags.length; i++) {
    var span = document.createElement("span");
    span.setAttribute("class", "badge rounded-pill bg-secondary");
    span.append(listSelectedTags[i]);
    td.appendChild(span);
}
    tr.appendChild(td);
    tr_tags.appendChild(tr);

}
    //Авторы книги
    function card_renderListAuthors(){
    const tr_tags =  document.getElementById("card-author-small");
    tr_tags.innerHTML = "";
    for (let i = 0; i < listSelectedAuthors.length; i++) {
    var div = document.createElement("div");
    var small = document.createElement("small");
    var a = document.createElement("a");
    div.setAttribute("class", "justify-content-between align-items-center");
    small.setAttribute("class", "text-muted");
    a.setAttribute("class", "a_conteiner a_author_conteiner");
    a.setAttribute("href", "http://localhost:8080");
    a.append(listSelectedAuthors[i]);
    small.append(a);
    div.appendChild(small);
    tr_tags.appendChild(div);
}
}
    //---------------------------------Выбор файла  обложки
    function handleClickSelectCover(obj){
    const coverImg = document.getElementById('card-cover-img');
    var fileElem = document.getElementById("input_file_cover_book");

    var file = fileElem.files[0];
    var reader = new FileReader();

    reader.onload = function(event) {
    coverImg.src = event.target.result;
};
    reader.readAsDataURL(file);
}
    // --------------------------------Общие
    renderAuthor();
    document.getElementById("NameClassInputSearchAuthors").addEventListener('input', e => {
    renderAllTegs(filter(e.target.value, listAllAuthors), allAuthors);});

    renderGenre();
    document.getElementById("NameClassInputSearchGenre").addEventListener('input', e => {
    renderAllTegs(filter(e.target.value, listAllGenres), allGenres);});

    renderTag();
    document.getElementById("NameClassInputSearchTag").addEventListener('input', e => {
    renderAllTegs(filter(e.target.value, listAllTags), allTags);});
    //-----------------------------------------------------------------------------------------------