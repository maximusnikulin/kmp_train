const grpc = require("@grpc/grpc-js");
const protoLoader = require("@grpc/proto-loader");
const PROTO_PATH = "./protos/app.proto";

const packageDefinition = protoLoader.loadSync(PROTO_PATH, {});
const myProto = grpc.loadPackageDefinition(packageDefinition).ZeusApiPackage;

const getData = (call, callback) => {
  callback(null, { accessToken: "at", refreshToken: "rt" });
};

const server = new grpc.Server();

server.addService(myProto.AuthenticationService.service, { ConfirmPhoneCode: getData });

server.bindAsync("127.0.0.1:3000", grpc.ServerCredentials.createInsecure(), (error, port) => {
  console.log(`Server running at http://127.0.0.1:${port}`);
  server.start();
});