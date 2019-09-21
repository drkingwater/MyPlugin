package com.pxq.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        //创建hellePlugin扩充对象
        project.extensions.create("helloPlugin", HelloExtension)

        project.task('hello', group: 'myplugin') {
            doLast {
                //use helloPlugin extension
                if (project.helloPlugin.say){
                    println project.helloPlugin.message
                }
            }
        }
    }
}