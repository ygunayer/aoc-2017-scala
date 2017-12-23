package com.yalingunayer.aoc

import scala.io.Source

object Utils {
  object InputUtils {
    def loadFile(name: String): String = {
      val res = getClass.getResource(name)
      val path = res.toString()
      Source.fromURL(path).mkString("")
    }
  }

  object ReflectionUtils {
    def getObjectInstance[A](fullName: String): Option[A] = {
      val mirror = scala.reflect.runtime.universe.runtimeMirror(getClass.getClassLoader)
      val module = mirror.staticModule(fullName)
      val obj = mirror.reflectModule(module)

      Option(obj).map(_.instance).map(_.asInstanceOf[A])
    }
  }
}
