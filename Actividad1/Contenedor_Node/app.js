const http = require("http");

const server = http.createServer((req, res) => {
  res.writeHead(200, {"Content-Type": "text/plain"});
  res.end("Current time is: " + new Date().toString());
});

const PORT = 3000;  // Puerto interno, mapea a otro puerto en el host
server.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});