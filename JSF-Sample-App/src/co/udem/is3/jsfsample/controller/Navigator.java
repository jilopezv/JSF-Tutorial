package co.udem.is3.jsfsample.controller;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Navigator {
	public String choosePage() {
		if (Math.random() > 0.5) {
			return ("result-page-1");
		} else {
			return ("result-page-2");
		}
	}
}