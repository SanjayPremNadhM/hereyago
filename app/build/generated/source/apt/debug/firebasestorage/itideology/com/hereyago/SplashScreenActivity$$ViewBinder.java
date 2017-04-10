// Generated code from Butter Knife. Do not modify!
package firebasestorage.itideology.com.hereyago;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SplashScreenActivity$$ViewBinder<T extends firebasestorage.itideology.com.hereyago.SplashScreenActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558535, "field 'btnLogin'");
    target.btnLogin = finder.castView(view, 2131558535, "field 'btnLogin'");
    view = finder.findRequiredView(source, 2131558536, "field 'btnSignUP'");
    target.btnSignUP = finder.castView(view, 2131558536, "field 'btnSignUP'");
  }

  @Override public void unbind(T target) {
    target.btnLogin = null;
    target.btnSignUP = null;
  }
}
