# Etapa de compilación
FROM golang:1.20-alpine AS builder
WORKDIR /app
COPY main.go .
RUN go build -o myapp

# Etapa final
FROM alpine:latest
WORKDIR /app
COPY --from=builder /app/myapp .
EXPOSE 4000
CMD ["./myapp"]