<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script>
            var logout = function(){
                $.ajax({
                    type: "POST",
                    url:  "/lesson35/login?logout",
                    success: function(){
                        $(location).attr('href', "/lesson35/");
                    }
                });
            };
            var getQuote = function() {
                var element = document.getElementsByName('symbol')[0];
                var symbol = element.value;
                $.ajax({
                    type: "GET",
                    url:  "/lesson35/quote",
                    contentType: "application/json; charset=utf-8",
                    data: "symbol=" + symbol,
                    dataType: 'json',
                    async: true,
                    success: function(quote) {
                        $('.stockSymbol').text("Symbol : " + quote.symbol);
                        $('.stockQuote').text("Quote : " + quote.quote);
                    }
                });
            };
        </script>
    </head>
    <body>
        <h3>Current user: ${currentUser}. Press to <a href="javascript:logout()">Logout</a></h3>
        <h1>Please input Symbol (e.g. MSFT, AMZN)</h1>
        <input type="text" name="symbol" on/>
        <input type="submit" name="submit" value="Request stock price" onclick="getQuote();"/>
        <div class="stockSymbol"></div>
        <div class="stockQuote"></div>
    </body>
</html>
