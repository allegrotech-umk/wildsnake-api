(function (document, window) {
  'use strict';

  let container = document.querySelector(".products");

  function insert(object) {
    let productElement = document.createElement("li");
    productElement.innerHTML = object.title;
    container.appendChild(productElement);
  }

  function getProducts() {
    window.fetch("/products")
      .then(response => response.json())
      .then(products => {
        products.forEach(insert);
      });
  }

  document.addEventListener("DOMContentLoaded", getProducts);

})(document, window);
