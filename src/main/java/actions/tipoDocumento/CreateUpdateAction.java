package actions.tipoDocumento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Services.ServTipoDocumento;
import forms.TipoDocumentoForm;

public class CreateUpdateAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		TipoDocumentoForm tdForm = (TipoDocumentoForm) form;
		ServTipoDocumento servTipoDocumento = new ServTipoDocumento();
		try {
			if (tdForm.getIdTipodocumento() != null && tdForm.getIdTipodocumento() > 0) {
				servTipoDocumento.update(tdForm);
			} else {
				servTipoDocumento.create(tdForm);
			}

			request.setAttribute("tiposDocumentos", servTipoDocumento.findAll());
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			tdForm.setListadoDocumentos(servTipoDocumento.findAll());
			request.setAttribute("tipoDocumentoForm", tdForm);
			return mapping.findForward("failure");
		}

	}

}
