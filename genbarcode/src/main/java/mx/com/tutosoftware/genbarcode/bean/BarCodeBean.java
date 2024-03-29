package mx.com.tutosoftware.genbarcode.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;


@ManagedBean
@ViewScoped
public class BarCodeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DashboardModel model;
	private String codebar;
	private String code;
	private String codeUpca;
	private String codeUpce;
	
	@PostConstruct
    public void init() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
        DashboardColumn column3 = new DefaultDashboardColumn();
         
        column1.addWidget("formatos");
        
         
        column2.addWidget("upca");
        
         
        column3.addWidget("upce");
 
        model.addColumn(column1);
        model.addColumn(column2);
        model.addColumn(column3);
    }
	
	 public void handleReorder(DashboardReorderEvent event) {
	        FacesMessage message = new FacesMessage();
	        message.setSeverity(FacesMessage.SEVERITY_INFO);
	        message.setSummary("Reordered: " + event.getWidgetId());
	        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
	         
	        addMessage(message);
	    }
	     
	    public void handleClose(CloseEvent event) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
	         
	        addMessage(message);
	    }
	     
	    public void handleToggle(ToggleEvent event) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
	         
	        addMessage(message);
	    }
	     
	    private void addMessage(FacesMessage message) {
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	     
	    public DashboardModel getModel() {
	        return model;
	    }
	public String getCodebar() {
		return codebar;
	}
	public void setCodebar(String codebar) {
		this.codebar = codebar;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeUpca() {
		return codeUpca;
	}

	public void setCodeUpca(String codeUpca) {
		this.codeUpca = codeUpca;
	}

	public String getCodeUpce() {
		return codeUpce;
	}

	public void setCodeUpce(String codeUpce) {
		this.codeUpce = codeUpce;
	}
	

}
