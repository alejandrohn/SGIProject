$(document).ready(function () {
    var selectedOption = $("select#searchPatternOptions").children("option:selected").val();
    if (selectedOption === "2") {
        $("input.searchPatternText").prop('type', 'date');
    }
    $("select#searchPatternOptions").change(function () {
        var selectedOption = $(this).children("option:selected").val();
        $("input.searchPatternText").prop('value', '');
        if (selectedOption === "2") {
            $("input.searchPatternText").prop('type', 'date');
        } else {
            $("input.searchPatternText").prop('type', 'text');
        }
    });
    $(".searchPatternForm").submit(function (event) {
        var selectedOption = $("select#searchPatternOptions").children("option:selected").val();
        $("input.searchPatternOptionSelected").prop('value', selectedOption);
    });
});