from flask import Flask, render_template
from data import Experiences
#from flask_mysqldb import MySQL 
#from wtforms import Form, StringField, TextAreaField, PasswordField, validators
#from passlib.hash import sha256_crypt

app = Flask(__name__)

Experiences = Experiences()

@app.route('/')
def index():
    return render_template('home.html')

@app.route('/education')
def education():
	return render_template('education.html')

@app.route('/experiences')
def experiences():
	return render_template('experiences.html', experiences=Experiences)

@app.route('/experience/PCW_Computer')
def pcw():
	return render_template('PCW_Computer.html')

@app.route('/experience/TBNG_Consulting')
def tbng():
	return render_template('TBNG_Consulting.html')

@app.route('/courseworks_and_skills')
def courseworks_and_skills():
	return render_template('Courseworks_and_Skills.html')

if __name__ == '__main__':
    app.run(debug=True)
