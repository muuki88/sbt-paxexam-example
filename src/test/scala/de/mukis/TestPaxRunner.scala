/**
 *  Copyright (C) 2009-2012 Typesafe Inc. <http://www.typesafe.com>
 */
package akka.osgi.test

import org.junit.runner.RunWith
import org.junit._
import org.junit.Assert._
import org.scalatest.{ BeforeAndAfterAll, Suite }
import org.scalatest.matchers.MustMatchers
import org.scalatest.junit.{ AssertionsForJUnit, JUnitSuite }
import org.ops4j.pax.exam.junit.{ JUnit4TestRunner, Configuration, ExamReactorStrategy }
import org.ops4j.pax.exam.Option
import org.ops4j.pax.exam.CoreOptions._
import org.ops4j.pax.exam.spi.reactors.AllConfinedStagedReactorFactory;


import org.osgi.framework.{ BundleContext, BundleActivator }
import javax.inject.Inject

/**
 *
 * @author Nepomuk Seiler
 */
@RunWith(classOf[JUnit4TestRunner])
@ExamReactorStrategy(Array(classOf[AllConfinedStagedReactorFactory]))
class TestPaxRunner extends JUnitSuite /* with Suite with MustMatchers */ {

  @Inject
  var ctx: BundleContext = _

  var activator: BundleActivator = _

  @Configuration
  def configure: Array[Option] = {
    options(
      junitBundles(),
      // Original site, but with awefull download time in the last two days -.-
      // bundle("http://download.scala-ide.org/sdk/e37/scala29/dev/site/plugins/org.scala-ide.scala.library_2.9.3.v20120906-004703-4c11a6593c.jar"),
      bundle("http://repository.mukis.de/org.scala-ide.scala.library_2.9.3.v20120906-004703-4c11a6593c.jar"),
      mavenBundle("org.scalatest", "scalatest_2.9.0", "1.8")
    )
  }

  /**
   * Imitating a bundle startup
   */
  @Before
  def setUp {
  }

  /**
   * Imitating a bundle shutdown
   */
  @After
  def tearDown {
  }

  @Test
  def testBundleContextAvailable {
    assertNotNull(ctx)
  }
  

}
