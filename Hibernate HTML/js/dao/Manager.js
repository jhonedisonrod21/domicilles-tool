
class Manager {

    constructor() {
        this.listProducts = [];
    }

    addProduct(product) {
        this.listProducts.push(product);
    }

    listenerProduct(event) {
        let textId = document.getElementsByName('input_id_product');
        console.log(textId.text);
    }
}