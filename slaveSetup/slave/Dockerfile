  FROM mysql/mysql-server:5.7.17
  COPY my.cnf /etc/my.cnf
  ENV MYSQL_ROOT_PASSWORD=hatdog
  COPY ./*.sql /docker-entrypoint-initdb.d/