package net.tutorial.jenkins.gsl.started

class HttpRequest implements Serializable {
    def script

    HttpRequest(script) {
        this.script = script
    }

    def getResource() {
        String output = ""
        try {

            URL url = new URL("http://dummy.restapiexample.com/api/v1/employee/88026");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }


            println("Output from Server .... \n");
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()))
            String inputLine
            StringBuffer content = new StringBuffer()
            while ((inputLine = input.readLine()) != null) {
                content.append(inputLine)
            }
            input.close()
            conn.disconnect();
            output = content

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return output
    }
}