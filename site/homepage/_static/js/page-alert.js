/**
 * Manages the page alert by showing the alert unless it was already closed in
 * a previous session.
 */

const ALERT_ELEMENT_ID = 'pageAlert';

const ALERT_ELEMENT_HEIGHT = 56;

const ALERT_LOCAL_STORAGE_ID = 'pageAlertState';

function displayPageAlert(node) {
	if (window.scrollY <= ALERT_ELEMENT_HEIGHT) {
		node.classList.remove('d-none');
	}

	if (
		window.scrollY > ALERT_ELEMENT_HEIGHT &&
		!node.classList.contains('d-none')
	) {
		node.classList.add('d-none');
	}
}

function initPageAlert() {
	const pageAlertState = localStorage.getItem(ALERT_LOCAL_STORAGE_ID);

	if (pageAlertState !== 'closed') {
		const pageAlertElement = document.getElementById(ALERT_ELEMENT_ID);

		if (pageAlertElement) {
			pageAlertElement.classList.remove('page-alert-hidden');

			document.body.classList.add('page-alert-open');

			const pageAlertContainer = pageAlertElement.parentNode;

			if (pageAlertContainer) {
				window.addEventListener('scroll', () =>
					displayPageAlert(pageAlertContainer)
				);
			}
		}

		$('#' + ALERT_ELEMENT_ID).on('closed.bs.alert', function () {
			localStorage.setItem(ALERT_LOCAL_STORAGE_ID, 'closed');

			document.body.classList.remove('page-alert-open');
		});
	}
}

// Initialize after DOM is ready

$(initPageAlert);
