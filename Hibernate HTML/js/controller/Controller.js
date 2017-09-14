
class Controller {

    constructor() {
        this.manager = new Manager();
    }

    actionListener(event) {
        var node = event.target || event.srcElement;
        switch (node.name) {
            case 'Edit':
                var table = document.getElementById("tableCategories");
                var row = table.insertRow(-1);
                var name = 10;
                row.innerHTML =
                    '<tr onclick="controller.index(this)">' +
                    '<td></td> ' +
                    '<td></td> ' +
                    '<td></td> ' +
                    '<td></td> ' +
                    '<td style="text-align:center;"> ' +
                    '<input id="edit1" type="submit" name="edit" value="Edit"> ' +
                    '</td> ' +
                    '<td style="text-align:center;"> ' +
                    '<input id="remove1" type="submit" name="remove" value="Remove"> ' +
                    '</td> ' +
                    '</tr>';
                break;
            case 'removeCategory':
                var table = document.getElementById("tableCategories");
                table.deleteRow(1);
                break;
            case 'removePlace':
                var table = document.getElementById("tablePlaces");
                table.deleteRow(1);
                break;
            case 'removeArticle':
                var table = document.getElementById("tableArticles");
                table.deleteRow(1);
                break;
            case 'removeProduct':
                var table = document.getElementById("tableProducts");
                table.deleteRow(1);
                break;
        }
    }

    index(value) {
        console.log(value.rowIndex);
    }
}