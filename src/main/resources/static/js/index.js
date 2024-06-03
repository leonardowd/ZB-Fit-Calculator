function submitForm(event) {
    event.preventDefault();
}

function showFoodCalories() {
    var e = document.getElementById("foodsName");
    var value = e.value;
    document.getElementById("gramsFood").value = value;
}

function calculate() {
    var e = document.getElementById("foodsName");
    var foodGrams = e.value;
    var e2 = document.getElementById("inputGrams");
    var inputGrams = e2.value;

    var calculate = Math.round(foodGrams * inputGrams).toFixed(2);

    submitForm(event);

    document.getElementById("showCalories").value = calculate + " Calorias";
}