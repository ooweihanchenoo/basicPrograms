DROP DATABASE IF EXISTS library;
CREATE DATABASE library;
USE library;

CREATE TABLE BOOKS
(
  isbn VARCHAR(10) NOT NULL,
  title VARCHAR(50) NOT NULL,
  edition NUMERIC(3) NOT NULL,
  pdate DATE NOT NULL,
  isbn_backups VARCHAR(10) NOT NULL,
  PRIMARY KEY (isbn, isbn_backups)
);

CREATE TABLE COPIES
(
  cpysn VARCHAR(20) NOT NULL,
  cpyamount INT NOT NULL,
  cpysn_backups VARCHAR(20) NOT NULL,
  isbn VARCHAR(10) NOT NULL,
  isbn_backups VARCHAR(10) NOT NULL,
  PRIMARY KEY (cpysn, cpysn_backups),
  FOREIGN KEY (isbn, isbn_backups) REFERENCES BOOKS(isbn, isbn_backups)
);

CREATE TABLE BOOKS_STATUS
(
  status VARCHAR(11) NOT NULL,
  loan_time DATE NOT NULL,
  cpysn VARCHAR(20) NOT NULL,
  cpysn_backups VARCHAR(20) NOT NULL,
  isbn VARCHAR(10) NOT NULL,
  isbn_backups VARCHAR(10) NOT NULL,
  FOREIGN KEY (cpysn, cpysn_backups) REFERENCES COPIES(cpysn, cpysn_backups),
  FOREIGN KEY (isbn, isbn_backups) REFERENCES BOOKS(isbn, isbn_backups)
);

CREATE TABLE BORROWERS_STATUS
(
  lnum VARCHAR(20) NOT NULL,
  lbooks VARCHAR(30) NOT NULL,
  ambooksout INT NOT NULL,
  lnum_backups VARCHAR(20) NOT NULL,
  dout DATE NOT NULL,
  din DATE NOT NULL,
  PRIMARY KEY (lnum, lnum_backups)
);

CREATE TABLE BORROWERS
(
  b_id VARCHAR(20) NOT NULL,
  b_id_backups VARCHAR(20) NOT NULL,
  name VARCHAR(30) NOT NULL,
  address VARCHAR(50) NOT NULL,
  isbn VARCHAR(10) NOT NULL,
  isbn_backups VARCHAR(10) NOT NULL,
  lnum VARCHAR(20) NOT NULL,
  lnum_backups VARCHAR(20) NOT NULL,
  PRIMARY KEY (b_id, b_id_backups),
  FOREIGN KEY (isbn, isbn_backups) REFERENCES BOOKS(isbn, isbn_backups),
  FOREIGN KEY (lnum, lnum_backups) REFERENCES BORROWERS_STATUS(lnum, lnum_backups)
);