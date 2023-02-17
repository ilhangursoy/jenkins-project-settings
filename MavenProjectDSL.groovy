job('First-Maven-Project-Via-DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github")
    scm {
        git("https://github.com/marcus-clarusway/java-tomcat-sample.git", 'master')
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven{
            goals('clean package')
            rootPOM('pom.xml')
            mavenInstallation('maven-3.6.0')
        }
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}
