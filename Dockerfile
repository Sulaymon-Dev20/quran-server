FROM openjdk:17-oracle as build
LABEL maintainer="portfolio"
#RUN apt-get update && apt-get install -y curl && \
#curl -s https://dl.eff.org/certbot-auto > /usr/local/bin/certbot-auto && \
#chmod 755 /usr/local/bin/certbot-auto
WORKDIR /app
COPY package.json *.lock ./
RUN yarn install
COPY . .
RUN yarn build-server
FROM nginx:1.21.3-alpine
COPY default.conf /etc/nginx/conf.d/default.conf
RUN rm -rf /usr/share/nginx/html/*
COPY --from=build /app/build /usr/share/nginx/html
#docker run -it --rm --name certbot -v /etc/letsencrypt:/etc/letsencrypt -v /var/lib/letsencrypt:/var/lib/letsencrypt certbot/certbot certonly --webroot --webroot-path=/var/www/html -d domain.com -d www.domain.com
#RUN /usr/local/bin/certbot-auto --non-interactive --install-only --webroot --webroot-path /usr/share/nginx/html -d test.sulaymonyahyo.com
RUN apt-get update && \
apt-get install -y certbot python-certbot-nginx && \
apt-get clean && \
rm -rf /var/lib/apt/lists/*
EXPOSE 80
EXPOSE 443
CMD ["nginx", "-g", "daemon off;"]
