package ca.polymtl.log4420.widgets

// from https://github.com/liftmodules/widgets/blob/master/src/main/scala/net/liftmodules/widgets/gravatar/Gravatar.scala

/*
 * Copyright 2007-2010 WorldWide Conferencing, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import scala.xml.NodeSeq
import java.security._
import java.util._
import java.io._
import net.liftweb.common.Loggable
  
/**
 * To make a Gravatar:
 *
 * <pre><code>
 * Gravatar("email@domain.com") // => Produces a gravatar thats 42x42 with a G rating
 * Gravatar("email@domain.com", 50) // => Produces a gravatar thats 50x50 with a G rating
 * Gravatar("email@domain.com", 50, "R") // => Produces a gravatar thats 50x50 with a R rating
 * </code></pre>
 *
 */
object Gravatar extends Loggable {
 
  val defaultSize: Int = 42
  val defaultRating: String = "G"
  val avatarEndpoint: String = "http://www.gravatar.com/avatar/"
 
  /**
   * @param e The email address of the recipient
   */
  def apply(e: String): NodeSeq = url(e,defaultSize,defaultRating)
 
  /**
   * @param e The email address of the recipient
   * @param s The square size of the output gravatar
   */
  def apply(e: String, s: Int): NodeSeq = url(e,s,defaultRating)
 
  /**
   * @param e The email address of the recipient
   * @param s The square size of the output gravatar
   * @param r The rating of the Gravater, the default is G
   */
  def apply(e: String, s: Int, r: String) = url(e,s,r)
 
  private def url(email: String, size: Int, rating: String): NodeSeq = {
    html(avatarEndpoint + getMD5(email) + "?s=" + size.toString + "&r=" + rating)
  }
 
  private def html(in: String): NodeSeq = {
    <img src={in} alt="Gravater" />
  }
 
  private def getMD5(message: String): String = {
    val md: MessageDigest = MessageDigest.getInstance("MD5")
    val bytes = message.getBytes("UTF-8") //("CP1252")
 
    try {
      BigInt(1,md.digest(bytes)).toString(16)
    } catch {
      case a: NoSuchAlgorithmException => logger.error("[Gravater] No Algorithm.", a); ""
      case x: UnsupportedEncodingException => logger.warn("[Gravater] Unsupported Encoding.", x); ""
      case _ => logger.warn("[Gravater] Unknown error."); ""
    }
  }
}