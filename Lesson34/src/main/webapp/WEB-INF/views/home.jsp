<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script>
            var getQuote = function() {
                var element = document.getElementsByName('symbol')[0];
                var symbol = element.value;
                $.ajax({
                    type: "GET",
                    url:  "/quote/quote",
                    contentType: "application/json; charset=utf-8",
                    data: "symbol=" + symbol,
                    dataType: 'json',
                    async: true,
                    success: function(quote) {
                        $('.stockSymbol').text("Symbol : " + quote.symbol);
                        $('.stockQuote').text("Quote : " + quote.quote);
                    }
                });
        }  
        </script>
    </head>
    <body>
        <h1>Please input Symbol (e.g. MSFT, AMZN)</h1>
        <input type="text" name="symbol"/>
        <input type="submit" name="submit" value="Request stock price" onclick="getQuote();"/>
        <div class="stockSymbol"></div>
        <div class="stockQuote"></div>
    </body>
</html>
