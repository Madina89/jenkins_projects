node{
    stage("Update jenkins"){
         properties([parameters([string(defaultValue: '63.35.199.158', description: 'Please provide IP', name: 'Environment ', trim: true)])])
         sh "echo Paramater added"
    }
    stage("Install git"){
        sh "ssh ec2-user@${Enviroment} sudo yum install git python-pip  -y"
    }
    stage("Pull Repo"){
      sh "ssh ec2-user@${Enviroment} git clone https://github.com/Madina89/flask-examples.git"
    }
    stage("Install Reguirements"){
       // sh "virualenv /tmp/venv"
        //sh ". /tmpvenv/bin/activate"
        sh "echo Hello"
    }
    stage("Pip Install"){
        sh "ssh ec2-user@${Enviroment} pip install -r ~/flsk-examples/requirements.txt"
    }
    stage("Run App"){
        sh "ssh ec2-user@${Enviroment} python  ~/flask-examples/01-hello-world/hello.py"
    }
}